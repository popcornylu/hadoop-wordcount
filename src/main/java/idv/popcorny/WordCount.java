package idv.popcorny;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCount {     


    public static void main(String[] args) throws Exception{
        
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        String in = "input.txt";
        String out = "out/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        if (otherArgs.length >= 1) {
            in = otherArgs[0];            
        }
        if (otherArgs.length >= 2) {
            out = otherArgs[1];            
        }
        
        Job job = Job.getInstance(conf, "word count");
        job.setJarByClass(WordCount.class);
        job.setMapperClass(WordCountMapper.class);
        job.setCombinerClass(WordCountReducer.class);
        job.setReducerClass(WordCountReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(in));
        FileOutputFormat.setOutputPath(job, new Path(out));
        System.out.println("The output goes to: " + out);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}


