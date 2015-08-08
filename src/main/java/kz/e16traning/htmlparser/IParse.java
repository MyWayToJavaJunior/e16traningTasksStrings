package kz.e16traning.htmlparser;

/**
 * Interface for realisation of parser.
 *
 */
public interface IParse {

    /**
     * File for parsing.
     *
     */
    String FILE_FOR_PARSE = "Java.SE.03.Information handling_task_attachment.html";

    /**
     * Author refers successively at pictures?
     *
     * @return true if successively,
     * false if not successively
     */
    boolean isSuccessively();

    /**
     * Sentences with referrals on pictures.
     *
     */
    String[] getSentences();
}
