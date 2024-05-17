import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import com.opencsv.CSVParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UniqueRecsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static final IntWritable one = new IntWritable(1);
    private Map<String, Integer> columnMap = new HashMap<>();
    private boolean isHeaderProcessed = false;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] parts = new CSVParser().parseLine(line);

        if (!isHeaderProcessed) {
            for (int i = 0; i < parts.length; i++) {
                columnMap.put(parts[i], i);
            }
            isHeaderProcessed = true;
            return;
        }

        String ProductId = parts[columnMap.get("ProductId")];
        String Score = parts[columnMap.get("Score")];
        String Time = parts[columnMap.get("Time")];

        Text outputKey = new Text("ProductId:" + ProductId + ", Score:" + Score + ", Time:" + Time);
        context.write(outputKey, one);
    }
}

