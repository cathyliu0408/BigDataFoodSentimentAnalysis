import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import com.opencsv.CSVParser;
import java.io.IOException;

public class AmazonCleanMapper extends Mapper<LongWritable, Text, NullWritable, Text> {
    private CSVParser parser = new CSVParser();

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() == 0) {
            return; 
        }

        String[] row = parser.parseLine(value.toString());
        if (row.length > 6) {
            if (row[0].equals("NULL") || row[0].equals("#NAME?") ||
                row[1].equals("NULL") || row[1].equals("#NAME?") ||
                row[2].equals("NULL") || row[2].equals("#NAME?") ||
                row[3].equals("NULL") || row[3].equals("#NAME?") ||
                row[4].equals("NULL") || row[4].equals("#NAME?") ||
                row[5].equals("NULL") || row[5].equals("#NAME?") ||
                row[6].equals("NULL") || row[6].equals("#NAME?")) {
                return;
            }

            row[2] = row[2].toLowerCase().trim();
            
            long unixTime = Long.parseLong(row[6]);
            String formattedDate = new java.text.SimpleDateFormat("MM-dd-yyyy").format(new java.util.Date(unixTime * 1000));

            int highScore = Integer.parseInt(row[3]) >= 4 ? 1 : 0;

            String cleanedRow = String.join(",", row[0], row[1], row[2], row[3], row[4], row[5], formattedDate, String.valueOf(highScore));
            context.write(NullWritable.get(), new Text(cleanedRow));
        }
    }
}
