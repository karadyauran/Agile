package com.karadyauran.agile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "projects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
  @Id
  @Column(name = "p_project_id")
  private UUID projectId;

  @Column(name = "p_project_name")
  private String projectName;

  @Column(name = "p_owner_id")
  private UUID ownerId;

  @Column(name = "p_description")
  private String description;

  @Column(name = "p_created_at")
  private LocalDate createdAt;

  @Column(name = "p_deadline")
  private Date deadline;

  @OneToMany(mappedBy = "projects", targetEntity = ProjectMember.class)
  private List<ProjectMember> projectMembers;
  @OneToMany(mappedBy = "projects", targetEntity = Task.class)
  private List<Task> tasks;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Project project = (Project) o;
    return Objects.equals(projectId, project.projectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId);
  }

  @Override
  public String toString() {
    return String.format("Project: %s, %s, %s, %s",
            projectId, projectName, createdAt, tasks);
  }
}
