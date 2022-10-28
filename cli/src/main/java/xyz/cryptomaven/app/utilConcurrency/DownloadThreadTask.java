package xyz.cryptomaven.app.utilConcurrency;

import xyz.cryptomaven.app.dao.BookmarkDAO;
import xyz.cryptomaven.app.dao.BookmarkDaoImpl;
import xyz.cryptomaven.app.models.Weblink;
import xyz.cryptomaven.app.util.DownloadSequential;
import xyz.cryptomaven.app.util.InputOutput;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DownloadThreadTask implements Runnable {
    private static int SUBSEQUENTS = 1;
    // STATIC VARS
    private static BookmarkDAO bookmDaoImpl= new BookmarkDaoImpl();
    private static final long TIME_FRAME = 3000000000L;

    // INSTANCE VARS
    private boolean downloadAll = false;

    ExecutorService downloadExecutor = Executors.newFixedThreadPool(5);

    // STATIC NESTED Downloader CLASS
    private static class Downloader<T extends  Weblink> implements Callable<T> {
        private T weblink;
        public Downloader(T weblink) {
            this.weblink = weblink;
        }
        public T call() {
            try {
                if(!weblink.getUrl().endsWith(".pdf")) {
                    weblink.setDownloadStatus(Weblink.DownloadStatus.FAILED);
                    String htmlPage = DownloadSequential.downloadFromUrl(weblink.getUrl());
                    weblink.setHtmlPage(htmlPage);
                } else {
                    weblink.setDownloadStatus(Weblink.DownloadStatus.NOT_ELIGIBLE);

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
            return weblink;
        }
    }

    public DownloadThreadTask(boolean downloadAll) {
        this.downloadAll = downloadAll;
    }


    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < SUBSEQUENTS) {
            // Get Weblinks - methods from BookmarkDao
            List<Weblink> weblinks = getWeblinks();
            // Download concurrently
            if(weblinks.size() > 0) {
                downloadThread(weblinks);
            } else {
                System.out.println("no new weblinks to download");
            }
            // Waits a few seconds, then continues with next weblinks to download
            try {
                TimeUnit.SECONDS.sleep(15);
                count++;
                if(SUBSEQUENTS ==count) {
                    System.out.println(       "Download task interval stopping now after " +count+ " intervals."       );}
            }  catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        downloadExecutor.shutdown();
    }

    private void downloadThread(List<Weblink> weblinks) {
        List< Downloader< Weblink>> tasks = getTasks(weblinks);
        List<Future< Weblink>> futures = new ArrayList<>();

        try {
            futures = downloadExecutor.invokeAll(tasks, TIME_FRAME, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Future< Weblink> future : futures) {
            try {
                // if any downloader can't download a page, then it will be canceled
                if (!future.isCancelled()) {
                  Weblink weblink = future.get();
                  String webpage = weblink.getHtmlPage();
                  if (webpage != null) {
                      InputOutput.writeWebpage(webpage, weblink.getId());
                      weblink.setDownloadStatus(Weblink.DownloadStatus.FAILED);
                      System.out.println("Concurrent webpage Download Succeeded: " + weblink.getUrl());
                  } else {
                      System.out.println("Concurrent webpage NOT Downloaded: " + weblink.getUrl());
                    }
                } else {
                    System.out.println("\n\nTask is cancelled --> " + Thread.currentThread());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


    }

    private List<Downloader<Weblink>> getTasks(List<Weblink> weblinks) {
        List<Downloader<Weblink>> tasks = new ArrayList<>();
        // Iterating through all the futures
        for (Weblink w : weblinks) {
            tasks.add(new Downloader<Weblink>(w));
        }
        return tasks;
    }

    private List<Weblink> getWeblinks() {
        List<Weblink> weblinks = null;
        if(downloadAll) {
            weblinks = bookmDaoImpl.getAllWebLinks();
            downloadAll = false; // so then will only look for new weblinks
        } else {
            weblinks = bookmDaoImpl.getWebLinks(Weblink.DownloadStatus.NOT_ATTEMPTED);

        }
        return weblinks;
    }


}
