# Introduction

In this assignment, you'll setting up your development environment and becoming familiar with the git source control system.   

# Setup

If you haven't already, go to github.com and sign up for an account.  You'll also need to [generate an SSH key] ( https://git-scm.com/book/en/v2/Git-on-the-Server-Generating-Your-SSH-Public-Key ) for GitHub so you don't have to enter your password repeatedly.


Next, visit GitHub Classroom to clone the class repository [here](https://classroom.github.com/assignment-invitations/58ed997ee132f36cb0de11df3acd9364):


After you create your new repository, you should be redirected to your own fork of the instructor's repository.  This is your private area within GitHub to work on assignments and submit your work.  To start writing code and modifying your repository, you need to clone your GitHub (hereafter referred to as "remote") repository on to your local machine.  Copy the clone URL of your repository from your browser and issue the following command from your EECS Unix account

`$ git clone <URL>`

For example, my command might look like

`$ git clone git@git://github.com/CS362-OSUF16/osu322f16-assignment-dfb-osu`

This will clone the main class repository, creating a copy of both the repository and the indiviual files in a subdirectory based on the GitHub URL. 

Now, `cd` in to the local directory

```
$ cd osu362f16-assignment-dfb-osu
$ ls -a
.git    README.md  submissions  templates
```

The files present are the latest version from your local repository. The hidden `.git` directory stores metadata about the repository and, most importantly, all of the history and commit data for this project.  You should rarely (in this class: *almost never*) need to access `.git`, instead, you'll be using git commands to commit files and make changes.

# Assignment I

## Part I - A first commit

Update the `README.md` file to include a single line with your name using your favorite text editor.  After you have completed this, try typing 


```
$ git status

On branch master
Your branch is up-to-date with 'origin/master'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

        modified:   README.md

no changes added to commit (use "git add" and/or "git commit -a")
```

Note that the file README.md has been modified even though no git command was issued. This file is now modified, but not staged. To commit README.md to a local repository, we must explicitly add it with 

```
$ git add README.md
$ git status
On branch master
Your branch is ahead of 'origin/master' by 2 commits.
  (use "git push" to publish your local commits)

Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

        modified:   README.md
```

Finally, commit the change to the local repository. Each time you commit, it is important to describe the changes you make.  A good rule of thumb is that the amount documentation in a commit should be proportional to the changes in the code.  For major changes, we might use

```
$ git commit 
```

which will open a text editor to edit a commit. This great when making major changes to the codebase, but for now, use the -m flag to commit with a simple message on the command line.

```
# git commit -m "Updated README.md with name"
```

Keep in mind that any changes that made are not part of the local repository until you `commit` 


## Part II - Pushing the to origin (GitHub)

Refresh your GitHub project page and notice that your change hasn't appeared on the website.  While the local repository is now updated, it is necessary to push those changes to the GitHub repository

```
$ git push origin master
```

In GitHub, your README.md will be rendered on your project page. Reload the page and ensure that README.md has your name. Keep in mind that any commits to a local repository are not made in a remote repository until you commit 

## Part III - Branching practice

Visit [this page](http://learngitbranching.js.org) and complete the first set of levels (Introduction Sequence)


## Part IV - Branching

The repository that you have forked has following file structure

```
#
|- README.md
|- submissions
 \- hw1
 \- hw2
 \- hw3
 \- hw4
 \- hw5
|- templates
 \- hw1
 \- hw2
 \- hw3
 \- hw4
 \- hw5
 ```

In this course, we will be following these conventions:

- All of the assignment files will be provided in the templates folder.  Your first course of action for each assignment should be to copy (using UNIX `cp`) the files from the templates directory to the submissions directory.  ***You should never alter files under templates*** - in a future assignment, we will learn how to pull from instructors repository to get new assignments as the are available.
- The submissions directory should contain your code, after adding all the files from the corresponding templates directory, you are free to alter the code as you wish. You should do your work against the master branch until you're ready to submit your code
- When you are ready to submit your code, you will create a new branch called `hwX`, where X is the number of the assignment.  The instructor and TAs will pull from this branch on GitHub and your submission date will be the timestamp of the last commit on that branch. Do not commit to this branch after the deadline!
- The walkthrough below should be similar for future assignments although you'll be working on multiple files.


Your final task is to 
   * create a new branch called `hw1`
   * change the submissions/hw1/README.md file on branch `hw1` to read "This is my submission!"
   * change the submissions/hw1/README.md file on branch `master` to read "This is my working copy!"
   * commit both branches and push both to GitHub

First, check the current branch. We currently only have one branch called master, this is the default branch.

```
$ git branch
* master
```

The `*` indicates the current branch on the filesystem. Let's add a new branch and start working on `hw1`

```
$ git branch hw1
$ git branch
  hw1
* master
```
Note that `branch` does not switch the current branch, so any edits you make after its creation are applied to the master branch.  The `checkout` command is used to switch branches

```
$ git checkout hw1
```
 
 Now, edit the  submissions/hw1/README.md file to read "This is my submission!" and then commit the change.
 
```
$ git add submissions/hw1/README.md 
$ git commit -m "Changed assignment 1 readme"
```

To submit the branch to github

```
$ git push origin hw1
```

Refresh your GitHub page - in the upper left hand corner, click the branch dropdown: you should see a new `hw1` branch - this is your submission. In future assignments, this will signal you've completed the homework - you may want to double check the submitted files.  For this assignment, we'll make one more change to the `master` branch. Make sure you're currently working on master 


```
$ git checkout master
$ git add submissions/hw1/README.md

```

Change the submissions/hw1/README.md file on branch `master` to read "This is my working copy!" and commit the master branch

```
$ git commit -m "Changed assignment 1 readme again!"
$ git push origin master
```

Switch back and forth between the `hw1` and `master` branches on your Github project page to ensure the submissions/hw1/README.md is different


## SUBMISSION CHECKLIST

Your repository should contain

- An edited README.md file as described in Part I/II
- Two branches `hw1` and `master` each containing a modified submissions/hw1/README.md as described in Part IV







