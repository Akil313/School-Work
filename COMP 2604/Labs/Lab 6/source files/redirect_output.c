#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main(void)
{
  int fd;


  fd = creat("output.txt", 0644);
  printf("\nThis text is before dup2\n");
  dup2(fd, 1);
  printf("\nThis text is after dup2\n");
  close(fd);

  printf("\nHere is some sample output.\n");
 }
