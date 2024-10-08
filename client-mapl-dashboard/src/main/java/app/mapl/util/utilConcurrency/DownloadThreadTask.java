package app.mapl.util.utilConcurrency;

import app.mapl.models.Weblink;
import app.mapl.util.DownloadSequential;
import app.mapl.util.InputOutput;
import app.mapl.util.constants.Datum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DownloadThreadTask implements Runnable {
    private static int SUBSEQUENTS = 1;
    // STATIC VARS

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
            DownloadSequential.download(weblink);
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
                System.out.println(Datum.ANSI_CYAN+ "Downloading "+weblinks.size()+" weblinks");
                downloadThread(weblinks);
            } else {
                System.out.println(Datum.ANSI_PURPLE+ "no new weblinks to download");
            }
            // Waits a few seconds, then continues with next weblinks to download
            try {
                TimeUnit.SECONDS.sleep(15);
                count++;
                if(SUBSEQUENTS ==count) {
                    System.out.println( Datum.ANSI_RED+      "Download task interval stopping now after " +count+ " intervals."       );}
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

        return weblinks;
    }


}
