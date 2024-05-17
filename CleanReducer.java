import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class CleanReducer extends Reducer<NullWritable, Text, NullWritable, Text> {
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        context.write(NullWritable.get(), new Text("Id,ProductId,UserId,HelpfulnessNumerator,HelpfulnessDenominator,Score,Time"));
    }

    @Override
    protected void reduce(NullWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for (Text value : values) {
            context.write(NullWritable.get(), value);
        }
    }
}
