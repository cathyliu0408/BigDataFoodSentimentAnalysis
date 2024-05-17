import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class AmazonSentimentReducer extends Reducer<Text, IntWritable, Text, NullWritable> {

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        context.write(new Text("ProductId,Date,Review Sentiment"), NullWritable.get());
    }

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        context.write(key, NullWritable.get());
    }
}
