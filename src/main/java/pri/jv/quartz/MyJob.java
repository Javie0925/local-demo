package pri.jv.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ClassName MyJob
 * @Dscription
 * @Date 2021/1/7
 * @Author JV
 **/
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz job");
    }
}
