package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image1")
public class ImageServlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/png");

        // Get image file from local directory
        String imagePath = "IMG_5123.JPG";
        File imageFile = new File(imagePath);

        // Set content length and caching headers
        response.setContentLength((int) imageFile.length());
        response.setHeader("Cache-Control", "public, max-age=86400");

        // Write image data to response output stream
        FileInputStream in = new FileInputStream(imageFile);
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        in.close();
        out.flush();
    }
}