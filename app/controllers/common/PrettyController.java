package controllers.common;

import com.googlecode.htmlcompressor.compressor.HtmlCompressor;
import play.Play;
import play.mvc.Content;
import play.mvc.Controller;
import play.mvc.Results;

/**
 * Extension for the play.mvc.Controller. Is used to render templates
 * to have clean HTML(no whitespaces).
 * <p>
 * It is only available in Dev mode.
 * <p>
 * Uses com.googlecode.htmlcompressor.compressor.HtmlCompressor to prettify the HTML.
 * Prettifies as a contentType="text/html; charset=utf-8"
 *
 * @author Peter Schmiedt
 * @version 1.0
 * @see play.mvc.Controller
 */
@SuppressWarnings("unused")
public class PrettyController extends Controller {

    public static final String contentType = "text/html; charset=utf-8";

    public static Results.Status ok(Content content) {
        return Results.ok(prettify(content)).as(contentType);
    }

    public static Results.Status badRequest(Content content) {
        return Results.badRequest(prettify(content)).as(contentType);
    }

    public static Results.Status notFound(Content content) {
        return Results.notFound(prettify(content)).as(contentType);
    }

    public static Results.Status forbidden(Content content) {
        return Results.forbidden(prettify(content)).as(contentType);
    }

    public static Results.Status internalServerError(Content content) {
        return Results.internalServerError(prettify(content)).as(contentType);
    }

    public static Results.Status unauthorized(Content content) {
        return Results.unauthorized(prettify(content)).as(contentType);
    }

    private static String prettify(Content content) {
        HtmlCompressor compressor = new HtmlCompressor();
        String output = content.body().trim();

        if (Play.isDev()) {
            compressor.setPreserveLineBreaks(true);
        }

        output = compressor.compress(output);

        return output;
    }
}
