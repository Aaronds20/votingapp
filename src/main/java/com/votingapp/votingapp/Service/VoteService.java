package com.votingapp.votingapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.votingapp.votingapp.Model.Option;
import com.votingapp.votingapp.Model.User;
import com.votingapp.votingapp.Model.Vote;
import com.votingapp.votingapp.Repository.OptionRepository;
import com.votingapp.votingapp.Repository.VoteRepository;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private OptionRepository optionRepository;

    public void UpdateVote(Long optionId, User loggedInUser) {
        Option option = optionRepository.findById(optionId).orElseThrow(() -> new RuntimeException("Option not found"));
        Vote vote = new Vote();
        vote.setOption(option);
        vote.setUser(loggedInUser);
        voteRepository.save(vote);
    }

}
