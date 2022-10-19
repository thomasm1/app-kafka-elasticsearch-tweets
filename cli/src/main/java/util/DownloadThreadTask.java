package util;

import dao.BookmarkDAO;
import dao.BookmarkDaoImpl;
import models.Weblink;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadThreadTask implements Runnable {
    private static BookmarkDAO bmDao= new BookmarkDaoImpl();

    private static final long TIME_FRAME = 300000000L;
    private boolean downloadAll = false;

    ExecutorService downloadExecutor = Executors.newFixedThreadPool(5);


    public DownloadThreadTask(boolean downloadAll) {
        this.downloadAll = downloadAll;
    }
    private static class Downloader<T extends Weblink> implements Callable<T> {
        private final boolean downloadAll;
        private T weblink;

        public Downloader(boolean downloadAll, T weblink) {
            this.downloadAll = downloadAll;
            this.weblink = weblink;
        }

        @Override
        public T call() throws Exception {
            try {
                String htmlPage = HTTPConnect.download(weblink.getUrl());
                weblink.setHtmlPage(htmlPage);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return weblink;
        }
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // Get Weblinks

            // Download concurrently

            // Wait
        }
        downloadExecutor.shutdown();
    }
}
