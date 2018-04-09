#include <stdio.h>
#include <sys/time.h>
#include <time.h>

int main(void){
  
    char* timestring;
	struct timeval currentTime;
  	
    gettimeofday(&currentTime,NULL);
	 
    printf("Seconds:%ld \n", currentTime.tv_sec);
	printf("Microseconds:%ld \n", (long)currentTime.tv_usec);
}
