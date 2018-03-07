package org.k9.demo 

def checkOutFrom(repo) {
  git url: "git@github.com:srinivasdevops376/${repo}"
}
return this
