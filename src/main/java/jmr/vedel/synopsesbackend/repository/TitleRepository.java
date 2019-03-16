package jmr.vedel.synopsesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jmr.vedel.synopsesbackend.entity.Title;

public interface TitleRepository extends JpaRepository<Title, Long>
{

}
