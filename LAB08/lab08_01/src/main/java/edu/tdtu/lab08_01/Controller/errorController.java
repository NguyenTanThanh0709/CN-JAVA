package edu.tdtu.lab08_01.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class errorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // get error status code
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            // handle different status codes
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404"; // return custom error page for 404 errors
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500"; // return custom error page for 500 errors
            }
        }

        return "/showerror"; // return default error page for all other errors
    }


    public String getErrorPath() {
        return "/error";
    }
}

