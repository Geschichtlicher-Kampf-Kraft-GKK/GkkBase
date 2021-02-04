url="https://github.com/Geschichtlicher-Kampf-Kraft-GKK/"
repo_names='"Architecture"'
suffix=".git"

for repo_name in repo_names
  do
    repo_url=$url$repo_name$suffix
    git pull $repo_url
    rm $repo_name/libs/gkkbase-current.jar
    cp build/libs/gkkbase-current.jar $repo_name/libs/gkkbase-current.jar
    cd $repo_name
    git add .
    git commit -m
    git push
    ls
    echo finished_$repo_name
  done
  rm -rf build/libs/
  
