import java.util.Calendar;

/**
 * Task 1 - creating log with StringBuffer
 *
 * @author Natalia Glazkina
 *
 */
@SuppressWarnings("WeakerAccess")
public class CrazyLogger {
    private StringBuilder logMessages;

    public CrazyLogger() {
        logMessages = new StringBuilder();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void addMessage(String msg) {
        //if message multiline
        msg.replaceAll("\n", " ");
        Calendar calendar = Calendar.getInstance();
        logMessages.append(String.format("%td-%<tm-%<tY : %<tH-%<tM - %s\n", calendar, msg));
    }

    @Override
    public String toString() {
        return logMessages.toString();
    }

    public void findAll(Calendar cal) {
        String dateTime = String.format("%td-%<tm-%<tY : %<tH-%<tM", cal);
        String[] splitters = logMessages.toString().split(dateTime);
        if (splitters.length > 1) {
            System.out.println("Messages at " + dateTime);
            for (int i = 1; i < splitters.length - 1; ++i) {
                System.out.print(splitters[i]);
            }
            int lastSymb = splitters[splitters.length - 1].indexOf("\n");
            System.out.println(splitters[splitters.length - 1].substring(0, lastSymb));
        } else {
            System.out.println("At " + dateTime + " no messages." );
        }
    }

    public void findAll(String message) {
        String[] splitters = logMessages.toString().split(message);
        if (splitters.length > 1) {
            System.out.println("Messages with pattern " + message);
            int first = splitters[0].lastIndexOf("\n");
            if (first == -1)
                System.out.print(splitters[0]);
            else
                System.out.print(splitters[0].substring(first, splitters[0].length() - 1));
            for (int i = 1; i < splitters.length - 1; ++i) {
                System.out.print(message + splitters[i]);
            }
            int last = splitters[splitters.length - 1].indexOf("\n");
            System.out.println(message + splitters[splitters.length - 1].substring(0, last));
        } else {
            System.out.println("No messages with pattern \"" + message + "\" found." );
        }
    }
    public static void main(String[] args) {
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("Test Message 1");
        logger.addMessage("Test Message 2");
        System.out.println(logger);

        logger.findAll(Calendar.getInstance());
        logger.findAll("Test");

        logger.findAll("NO");
    }
}
