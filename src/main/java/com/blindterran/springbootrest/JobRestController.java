package com.blindterran.springbootrest;

import com.blindterran.springbootrest.model.JobPost;
import com.blindterran.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public Optional<JobPost> getJobById(@PathVariable("postId") int postId) {
        return jobService.getJobById(postId);
    }

    @PostMapping("jobPost")
    public Optional<JobPost> addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobService.getJobById(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public Optional<JobPost> updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getJobById(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJobById(@PathVariable("postId") int postId) {
        jobService.deleteJob(postId);
        return "Job has been deleted";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> getJobsByKeyword(@PathVariable("keyword") String keyword) {
        return jobService.search(keyword);
    }

    @GetMapping("load")
    public String loadAllJobs() {
        jobService.load();
        return "Job has been loaded";
    }
}
