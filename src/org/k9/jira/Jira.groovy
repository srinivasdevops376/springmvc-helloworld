package org.k9.jira
import org.k9.*
class Jira implements Serializable {
   def config
   def script

   Jira(script, config) {
      this.script = script
      this.config = config
   }

   def createTicket() {
      this.script.jiraNewIssue issue: this.config, site: 'jira'
   }
}
