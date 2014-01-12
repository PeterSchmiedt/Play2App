package controllers;

import controllers.common.PrettyController;
import models.Project;
import models.Task;
import play.mvc.Result;
import views.html.index;

/**
 * Main Application Controller
 */
public class Application extends PrettyController {

    public static Result index() {
        return ok(index.render(Project.find.all(), Task.find.all()));
    }
}