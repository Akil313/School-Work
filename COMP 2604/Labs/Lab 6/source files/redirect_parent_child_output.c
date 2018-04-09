#include <stdio.h>
#include <sys/types.h>
#include <fcntl.h>
#include <unistd.h>

int main(void)
{
  pid_t pid;
  int fd;

  pid = fork();

  if (pid == 0)
    {
      fd = creat("child_output.txt", 0644);
      dup2(fd, 1);
      close(fd);

      execl("/bin/ps", "ps", "au", "-u", NULL);
    }
  else if (pid > 0)
    {
      fd = creat("parent_output.txt", 0644);
      dup2(fd, 1);
      close(fd);

      execl("/bin/ls", "ls", "-l", NULL);
    }
}
