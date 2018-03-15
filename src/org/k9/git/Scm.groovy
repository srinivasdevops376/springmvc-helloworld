package org.k9.git
import org.k9.*

class Scm implements Serializable {
  def config
  def script

  Scm(script,config) {
    this.config = config
    this.script = script
  }
  
  void checkout(){    
    this.script.stage('gitclone'){
        this.script.git(url: this.config.scm_url, branch: this.config.scm_branch)
    }
  
    }
  }
