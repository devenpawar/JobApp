package com.deven.spring_boot_react.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deven.spring_boot_react.model.JobPost;
import com.deven.spring_boot_react.repo.JobRepo;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        System.out.println("IN ADD JOB SERVICE");
        repo.save(jobPost);
    }

    public JobPost getJob(int i) {
        return repo.findById(i).orElse(new JobPost());
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(List.of(
                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "Frontend Developer",
                        "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React")),
                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),
                new JobPost(4, "Network Engineer",
                        "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),
                new JobPost(5, "Mobile App Developer",
                        "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App")),
                new JobPost(6, "DevOps Engineer",
                        "Implement and manage continuous integration and delivery pipelines", 4,
                        List.of("DevOps", "CI/CD", "Docker", "Kubernetes")),
                new JobPost(7, "UI/UX Designer",
                        "Create engaging user experiences and intuitive user interfaces", 2,
                        List.of("User Experience", "User Interface Design", "Prototyping")),
                new JobPost(8, "Cybersecurity Analyst",
                        "Protect computer systems and networks from cyber threats", 4,
                        List.of("Cybersecurity", "Network Security", "Incident Response")),
                new JobPost(9, "Full Stack Developer", "Experience in both front-end and back-end development",
                        5,
                        List.of("JavaScript", "Node.js", "React", "Spring", "MongoDB")),
                new JobPost(10, "Cloud Architect", "Design and implement cloud infrastructure solutions", 6,
                        List.of("Cloud Computing", "AWS", "Azure", "Google Cloud"))));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
