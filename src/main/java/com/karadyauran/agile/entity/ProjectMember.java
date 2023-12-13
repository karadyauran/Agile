package com.karadyauran.agile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "project_members")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMember {
  @Id
  @Column(name = "project_member_id")
  private UUID projectMemberId;

  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "role_id")
  private UUID roleId;

  @OneToOne(mappedBy = "projectMember", targetEntity = Role.class)
  private Role role;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProjectMember that = (ProjectMember) o;
    return Objects.equals(projectMemberId, that.projectMemberId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectMemberId);
  }

  @Override
  public String toString() {
    return String.format("ProjectMember: %s, %s",
            userId, role);
  }
}
