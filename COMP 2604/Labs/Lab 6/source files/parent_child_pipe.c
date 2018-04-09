#include <stdio.h>
#include <fcntl.h>
#include <string.h>

#include <unistd.h>

int main(void)
{
  pid_t pid;
  int p[2];
  FILE *fp;
  int fd2, fd1;

  pipe(p);

  pid = fork();

  if (pid == 0)
    {
      char str[100];      
      
      fp = fdopen(p[0], "r");

      printf("\nThis is the child process.\n");
      fgets(str, 100, fp);
      
      while (strstr(str, "Last Line") == NULL)
	{
	  printf("\nReceived from parent process (through pipe): %s", str); fflush(stdout);
	  fgets(str, 100, fp);
	}
      printf("\nReceived the last line from the parent.");
    }
  else if (pid > 0)
    {
      int i;
      
      printf("\nThis is the parent process.");
      fp = fdopen(p[1], "w");
      

      for (i=0; i<10; i++)
	{
	  printf("\nSending to child process (through pipe): Here is line %d", i);
	  fprintf(fp, "Here is line %d\n", i);
	}

      printf("\nSending the last line to child process (through pipe)");
      fprintf(fp, "Last Line\n");
      
      fflush(fp);
    }
    
    fclose(fp);
    close(p[0]);
    close(p[1]);
}
