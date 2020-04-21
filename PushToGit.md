1.初始化本地仓库。在本地项目根目录中打开Gti命令行，执行：

```kotlin
git init  //初始化本地仓库
```

2.将本地项目的所有文件添加到暂存区。小数点 “**.**” ，意为添加文件夹下的所有文件；也可以将 “.” 换成具体的文件名，如果想添加项目中的指定文件，那就把 “**.**” 改为指定文件名即可。

```csharp
git add .   //将本地项目的所有文件添加到暂存区
```

3.将暂存区的文件提交到本地仓库,并添加说明信息:

```bash
git commit -m "说明信息"   
```

**至此，本地项目提交到本地仓库完成。**



将本地仓库代码推送到GitLab远端仓库。

1.首先，建立本地仓库和远端GitLab仓库的关联关系：

```csharp
git remote add origin  https://gitlab*********************.git
```

在这一步时如果出现错误：fatal:remote origin already exists，先清除一下关联关系：

```undefined
git remote rm origin
```

再重新关联：

```csharp
git remote add origin  https://gitlab*********************.git
```

2.检查关联是否已建立且正确：

```undefined
git remote -v
```

3.将代码由本地仓库上传到 GitLab 远端仓库，依次执行下列语句。
 获取远程库与本地同步合并：

```undefined
git pull --rebase origin master
```

> **如果远程库不为空必须做这一步，否则后面的提交会失败,不加这句可能报错，原因是 GitLab中的 README.md 文件不在本地仓库中,可以通过该命令进行代码合并。**

把当前分支 master 推送到远程：

```undefined
git push -u origin master
```

> 执行完之后如果无错误就上传成功了，需要提示的是这里的 master 是 GitLab默认的分支，如果你本地的当前分支不是 master，就用git checkout master命令切换到master分支，如果你想用本地当前分支上传代码，则把上面两条命令里的 master 切换成你的当前分支名即可。

如果推送不成功，先pull一下，如果报错fatal: refusing to merge unrelated histories，说明本地和远端的git库是两个 根本不相干的 git 库， 然后本地要去推送到远端， 远端觉得这个本地库跟自己不相干， 所以告知无法合并。解决方法：强制合并：

```undefined
git pull origin master --allow-unrelated-histories
```

后面加上 --allow-unrelated-histories ，意思是把两段不相干的分支进行强行合并。
 然后再将代码推送到远端。

至此，操作成功。

