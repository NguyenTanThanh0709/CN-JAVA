package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class handle_bai4
 */
@WebServlet("/handle_bai4")
public class handle_bai4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "uploads";
    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("txt", "doc", "docx", "img", "pdf", "rar", "zip");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create path to uploads directory
        String appPath = request.getServletPath();
        String uploadPath = appPath + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Get form data
        String fileName = request.getParameter("name");
        Part filePart = ((Object) request).getPart("namefile");
        String overrideIfExists = request.getParameter("overrideIfExists");

        // Check if file extension is allowed
        String fileExtension = getFileExtension(fileName);
        if (!ALLOWED_EXTENSIONS.contains(fileExtension)) {
            response.getWriter().println("Unsupported file extension");
            return;
        }

        // Check if file already exists
        File uploadedFile = new File(uploadPath + File.separator + fileName);
        if (uploadedFile.exists() && overrideIfExists == null) {
            response.getWriter().println("File already exists");
            return;
        }

        // Save file
        filePart.write(uploadPath + File.separator + fileName);

        // Return response
        String fileUrl = request.getContextPath() + "/" + UPLOAD_DIR + "/" + fileName;
        response.setContentType("text/html");
        response.getWriter().println("File uploaded. Click <a href=\"" + fileUrl + "\">here</a> to visit file.");
    }

    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

}