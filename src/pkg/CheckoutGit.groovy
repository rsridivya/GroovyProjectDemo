package pkg

def checkOutFrom(repo) {
    git url: "https://github.com/rsridivya/${repo}.git"
}

return this
