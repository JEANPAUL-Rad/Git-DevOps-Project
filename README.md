#  Git & DevOps Project — Command History & Walkthrough

A documented walkthrough of Git branching, stashing, merging, and conflict 
resolution performed during the QA Engineering Git & DevOps assignment.

---

## 1. Branch Creation & Switching
```bash
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git branch dev
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git checkout dev
Switched to branch 'dev'
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git checkout -b test
Switched to a new branch 'test'
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git branch --show-current
test
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git checkout dev
Switched to branch 'dev'
```

---

## 2. Staging, Committing & Pushing to `dev`
```bash
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git add .
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git commit -m "dev branch"
[dev 0bce9c5] dev branch
1 file changed, 0 insertions(+), 0 deletions(-)
create mode 100644 history.txt
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git branch --show-current
dev
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git push origin dev
Enumerating objects: 4, done.
Counting objects: 100% (4/4), done.
Delta compression using up to 12 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 814 bytes | 814.00 KiB/s, done.
Total 3 (delta 1), reused 0 (delta 0), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
remote:
remote: Create a pull request for 'dev' on GitHub by visiting:
remote:      https://github.com/JEANPAUL-Rad/Git-DevOps-Project/pull/new/dev
remote:
To https://github.com/JEANPAUL-Rad/Git-DevOps-Project.git
* [new branch]      dev -> dev
```

---

## 3. Deleting a Local & Remote Branch
```bash
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git branch
* dev
  main
  test
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git branch -d tes
error: branch 'tes' not found
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git branch -d test
Deleted branch test (was 3fc2150).
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git push origin --delete test
error: unable to delete 'test': remote ref does not exist
error: failed to push some refs to 'https://github.com/JEANPAUL-Rad/Git-DevOps-Project.git'
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git ls-remote --heads origin
0bce9c5d0d61f1522b0d089c5333e64b5644e586        refs/heads/dev
3fc2150091e9c41edf645a610f7330526a41f432        refs/heads/main
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git branch -a
* dev
  main
  remotes/origin/HEAD -> origin/main
  remotes/origin/dev
  remotes/origin/main
```

---

##  4. Feature Branch — `ft/setup`
```bash
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git branch --show-current
ft/setup
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git add test.java
fatal: pathspec 'test.java' did not match any files
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git add .
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git commit -m "feat: add test.java with addition of 2 positive numbers logic"
[ft/setup 61407c9] feat: add test.java with addition of 2 positive numbers logic
3 files changed, 85 insertions(+)
delete mode 100644 history.txt
create mode 100644 src/test/java/test.java
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git push origin ft/setup
Enumerating objects: 15, done.
Counting objects: 100% (15/15), done.
Delta compression using up to 12 threads
Compressing objects: 100% (7/7), done.
Writing objects: 100% (13/13), 1.83 KiB | 937.00 KiB/s, done.
Total 13 (delta 3), reused 0 (delta 0), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (3/3), completed with 1 local object.
remote:
remote: Create a pull request for 'ft/setup' on GitHub by visiting:
remote:      https://github.com/JEANPAUL-Rad/Git-DevOps-Project/pull/new/ft/setup
remote:
To https://github.com/JEANPAUL-Rad/Git-DevOps-Project.git
* [new branch]      ft/setup -> ft/setup
```

---

## 5. Git Stash — Save & Restore Work
```bash
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git stash
Saved working directory and index state WIP on ft/setup: 61407c9 feat: add test.java with addition of 2 positive numbers logic
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git stash list
stash@{0}: WIP on ft/setup: 61407c9 feat: add test.java with addition of 2 positive numbers logic
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git stash apply 0
On branch ft/setup
Changes not staged for commit:
(use "git add <file>..." to update what will be committed)
(use "git restore <file>..." to discard changes in working directory)
modified:   src/test/java/test.java

no changes added to commit (use "git add" and/or "git commit -a")
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git diff
diff --git a/src/test/java/test.java b/src/test/java/test.java
index a031acb..5591e00 100644
--- a/src/test/java/test.java
+++ b/src/test/java/test.java
@@ -5,6 +5,8 @@ public class test {
int c = a+b;
System.out.println(c);

+        //verifying stash if its works
+

}
}
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git add .
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git commit -m "restoring stashed lines"
[ft/setup d185af3] restoring stashed lines
1 file changed, 2 insertions(+)
```

---

## 6. Switching Branches Safely with Stash
```bash
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git status
On branch ft/setup
Changes not staged for commit:
modified:   README.md

no changes added to commit (use "git add" and/or "git commit -a")
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git add .
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git switch main
error: Your local changes to the following files would be overwritten by checkout:
README.md
Please commit your changes or stash them before you switch branches.
Aborting
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git stash
Saved working directory and index state WIP on ft/setup: d185af3 restoring stashed lines
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git switch main
Switched to branch 'main'
Your branch is up to date with 'origin/main'.
```

---

## 7. Pulling from Other Branches into `main`
```bash
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git pull origin dev
From https://github.com/JEANPAUL-Rad/Git-DevOps-Project
* branch            dev        -> FETCH_HEAD
Updating 3fc2150..0bce9c5
Fast-forward
history.txt | Bin 0 -> 8702 bytes
1 file changed, 0 insertions(+), 0 deletions(-)
create mode 100644 history.txt
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git pull origin ft/setup
From https://github.com/JEANPAUL-Rad/Git-DevOps-Project
* branch            ft/setup   -> FETCH_HEAD
Updating 0bce9c5..d185af3
Fast-forward
README.md               |  75 ++++++++++++++++++++++++++++++++++++++++++++++++
history.txt             | Bin 8702 -> 0 bytes
src/test/java/test.java |  12 ++++++++
3 files changed, 87 insertions(+)
delete mode 100644 history.txt
create mode 100644 src/test/java/test.java
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git add .
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git commit -m "Creating conflict"
[main 43fe3bb] Creating conflict
1 file changed, 1 insertion(+), 1 deletion(-)
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git push origin main
Enumerating objects: 11, done.
Counting objects: 100% (11/11), done.
Delta compression using up to 12 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (6/6), 466 bytes | 466.00 KiB/s, done.
Total 6 (delta 2), reused 0 (delta 0), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (2/2), completed with 2 local objects.
To https://github.com/JEANPAUL-Rad/Git-DevOps-Project.git
3fc2150..43fe3bb  main -> main
```

---

## 8. Merge & Conflict Resolution
```bash
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git checkout ft/setup
Switched to branch 'ft/setup'
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git merge main
Updating d185af3..43fe3bb
Fast-forward
src/test/java/test.java | 2 +-
1 file changed, 1 insertion(+), 1 deletion(-)
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git merge main
Already up to date.
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git stash
No local changes to save
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git add .
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git commit -m "chore: resolve merge conflict with main branch"
On branch ft/setup
nothing to commit, working tree clean
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git psh origin ft/setup
git: 'psh' is not a git command. See 'git --help'.

The most similar command is
push
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git push origin ft/setup
Total 0 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
To https://github.com/JEANPAUL-Rad/Git-DevOps-Project.git
d185af3..43fe3bb  ft/setup -> ft/setup
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git switch main
Switched to branch 'main'
Your branch is up to date with 'origin/main'.
```