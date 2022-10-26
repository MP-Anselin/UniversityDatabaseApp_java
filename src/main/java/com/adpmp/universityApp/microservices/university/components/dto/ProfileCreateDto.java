package com.adpmp.universityApp.microservices.university.components.dto;

import com.adpmp.universityApp.microservices.profiles.components.model.Account;

import javax.validation.constraints.NotNull;

public class ProfileCreateDto {
   @NotNull
   private Account account;

   private String process = "NO_START";

   public String getProcess() {
      return process;
   }

   public void setProcess(String process_apply) {
      this.process = process_apply;
   }

   public Account getAccount() {
      return account;
   }

   public void setAccount(Account account_id) {
      this.account = account_id;
   }
}
