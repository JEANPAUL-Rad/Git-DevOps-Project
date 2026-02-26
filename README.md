# Git and DevOps assignment

PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git branch dev
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git checkout dev

Switched to branch 'dev'
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git checkout -b  test
Switched to a new branch 'test'
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git branch --show-current
test
PS E:\TheGymTraining\QA Engineering\Git & DeveOps project\Git-DeveOps-Project> git checkout dev

Switched to branch 'dev'
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

  Id CommandLine
  -- -----------                                                                              
  1 git branch dev                                                                           
  2 git checkout dev                                                                         
  3 git checkout -b  test                                                                    
  4 git branch --show-current                                                                
  5 git checkout dev                                                                         
  6 git add .                                                                                
  7 git commit -m "dev branch"                                                               
  8 git branch --show-current                                                                
  9 git push origin dev                                                                      
  10 git branch                                                                               
  11 git branch -d tes                                                                        
  12 git branch -d test                                                                       
  13 git push origin --delete test                                                            
  14 git push origin --delete test                                                            
  15 git ls-remote --heads origin                                                             
  16 git branch -a 