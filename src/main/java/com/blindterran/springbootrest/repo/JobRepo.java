package com.blindterran.springbootrest.repo;

import com.blindterran.springbootrest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {
    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Software Engineer", "Good Experience", 2, new ArrayList<>((Arrays.asList("Java", "Python")))),
            new JobPost(2, "Software Engineer 2", "Good Experience", 2, new ArrayList<>((Arrays.asList("Java", "Python"))))
    ));

    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public void addJob(JobPost job) {
        jobs.add(job);
        System.out.println(jobs);
    }

    public JobPost getJob(int id) {
        for (JobPost job : jobs) {
            if (id == job.getPostId())
                return job;
        }
        return null;
    }

    public void updateJob(JobPost jobPost) {
        for (JobPost job : jobs) {
            if (job.getPostId() == jobPost.getPostId()) {
                job.setPostProfile(jobPost.getPostProfile());
                job.setPostDesc(jobPost.getPostDesc());
                job.setReqExperience(jobPost.getReqExperience());
                job.setPostTechStack(jobPost.getPostTechStack());
            }
        }

    }

    public void deleteJob(int jobId) {
        jobs.removeIf(j -> j.getPostId() == jobId);
    }
}
