package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("file");
        if (fileName == null) {
            response.getWriter().write("File not found");
            return;
        }
        File file = new File(getClass().getResource("/" + fileName).getFile());
        if (!file.exists()) {
            response.getWriter().write("File not found");
            return;
        }
        String contentType = getServletContext().getMimeType(file.getName());
        response.setContentType(contentType);
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        int bufferSize = 1024;
        try (InputStream inputStream = new FileInputStream(file);
                OutputStream outputStream = response.getOutputStream();) {
            byte[] buffer = new byte[bufferSize];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                int sleepTime = getDownloadSpeed(request.getParameter("speed"));
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
            }
            outputStream.flush();
        } catch (Exception e) {
            response.getWriter().write("Error downloading file");
        }
    }
    
    
    private int getDownloadSpeed(String speed) {
        if (speed != null) {
            try {
                return (int) ((1024 * 8) / Integer.parseInt(speed));
            } catch (NumberFormatException e) {
                // ignore
            }
        }
        return 1;
    }
}
