package com.sidbi.vdf.service;

import com.sidbi.vdf.domain.CommitteeMeeting;
import com.sidbi.vdf.domain.MeetingVote;
import com.sidbi.vdf.domain.enums.MeetingOutcome;
import com.sidbi.vdf.domain.enums.MeetingStatus;
import com.sidbi.vdf.domain.enums.MeetingType;
import com.sidbi.vdf.repository.CommitteeMeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommitteeMeetingService {

    private final CommitteeMeetingRepository committeeMeetingRepository;

    public List<CommitteeMeeting> list(MeetingType type) {
        if (type != null) {
            return committeeMeetingRepository.findByTypeOrderByMeetingNumberDesc(type);
        }
        return committeeMeetingRepository.findAllByOrderByUpdatedAtDesc();
    }

    public CommitteeMeeting getById(UUID id) {
        return committeeMeetingRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Meeting not found: " + id));
    }

    @Transactional
    public CommitteeMeeting create(CommitteeMeeting meeting) {
        meeting.setId(null);
        meeting.setVotes(meeting.getVotes() != null ? meeting.getVotes() : new ArrayList<>());
        meeting.setCreatedAt(Instant.now());
        meeting.setUpdatedAt(Instant.now());
        return committeeMeetingRepository.save(meeting);
    }

    @Transactional
    public void updateStatus(UUID id, MeetingStatus status, MeetingOutcome outcome) {
        CommitteeMeeting m = getById(id);
        m.setStatus(status);
        if (outcome != null) m.setOutcome(outcome);
        m.setUpdatedAt(Instant.now());
        committeeMeetingRepository.save(m);
    }

    @Transactional
    public void addVote(UUID meetingId, MeetingVote vote) {
        CommitteeMeeting m = getById(meetingId);
        if (m.getVotes() == null) m.setVotes(new ArrayList<>());
        if (vote.getTimestamp() == null) vote.setTimestamp(Instant.now().toString());
        m.getVotes().add(vote);
        m.setUpdatedAt(Instant.now());
        committeeMeetingRepository.save(m);
    }
}
