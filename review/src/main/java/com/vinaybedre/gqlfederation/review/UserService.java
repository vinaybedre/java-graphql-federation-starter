package com.vinaybedre.gqlfederation.review;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    public List<Review> reviews = new ArrayList<>();
    public List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User("1", "@ada"));
        users.add(new User("2", "@complete"));
        reviews.add(new Review("1","Love it!", new User("1"), new Product("1")));
        reviews.add(new Review("2","Too expensive.", new User("1"), new Product("2")));
        reviews.add(new Review("3","Could be better.", new User("2"), new Product("3")));
        reviews.add(new Review("4","Prefer something else.", new User("2"), new Product("1")));
    }

    public User lookupUser(String id) {
        User user1 = users.stream().filter(user -> user.getId().equals(id)).findAny().get();
        user1.setReviews(reviews.stream()
                .filter(review -> review.getAuthor().getId().equals(user1.getId()))
                .collect(Collectors.toList()));
        return user1;
    }
}
