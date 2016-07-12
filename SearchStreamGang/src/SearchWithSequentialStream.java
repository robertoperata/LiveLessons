import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Customizes the SearchStreamGangCommon framework to use a sequential
 * Java Stream to search the input data for each word in an array of
 * words.
 */
public class SearchWithSequentialStream
             extends SearchStreamGangCommon {
    /**
     * Constructor initializes the super class.
     */
    SearchWithSequentialStream(String[] wordsToFind,
                               String[][] stringsToSearch) {
        // Pass input to superclass constructor.
        super(wordsToFind,
              stringsToSearch);
    }

    /**
     * Perform the processing, which uses a Java 8 Stream to
     * sequentially search for words in the input data.
     */
    @Override
    protected List<SearchResults> processStream() {
    	// Get the input.
        return getInput()
            // Sequentially process each String in the input list.
            .stream()

            // Map each String to a Stream containing the words found
            // in the input.
            .flatMap(this::processInput)

            // Terminate the stream.
            .collect(Collectors.toList());
    }
}

