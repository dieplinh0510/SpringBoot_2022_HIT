package com.example.btvn_buoi_5.repository;

import com.example.btvn_buoi_5.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository <Link, Long> {
    Link findLinkByShortedLink(String shortedLink);
    Link findLinkByOriginalLink(String originalLink);
}
