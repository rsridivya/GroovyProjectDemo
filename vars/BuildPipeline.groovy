import pkg


def call (body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
        agent {
            node {
                label "master"
            }
        }

        stages{
            stage('Build'){
                steps{
                    echo "First Stage Check"
                }
            }

            stage('Checkout'){
                steps{
                    echo "Checking Out Git Repo"
                    new Checkout().checkOutFrom("HelloWorld_Java")
                }
            }
        }
    }
}