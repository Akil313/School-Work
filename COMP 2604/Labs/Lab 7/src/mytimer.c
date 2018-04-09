#include <stdio.h>
#include <sys/time.h>

int main(){

struct itimerval v;

v.it_interval.tv_sec = 10;//reset the timer to 10sec 0usec, when it expires
v.it_interval.tv_usec = 0;
v.it_value.tv_sec = 10;//current value of the timer is 10sec 0usec
v.it_value.tv_usec = 0;

setitimer( ITIMER_REAL, &v, NULL );//a real interval timer is set up
 printf( "%ld %ld\n", (long)v.it_value.tv_sec, (long)v.it_value.tv_usec);//current time printed
 printf( "%ld %ld\n", (long)v.it_interval.tv_sec, (long)v.it_interval.tv_usec);//current time printed
int i, j, t;
for( i=0 ; i<1000 ; i++)
{
   for( j=0 ; j<9999999 ; j++)//waste some time, for loop prolonged
   	;//the null instruction executed

   t = getitimer( ITIMER_REAL, &v );//the current value of a real timer is fetched
  // printf("t=%d\n", t);
   printf( "for %d : %ld %ld\n", i, (long)v.it_value.tv_sec, (long)v.it_value.tv_usec);//current time printed
}
 printf( "after for: %d %ld %ld\n", i, (long)v.it_value.tv_sec, (long)v.it_value.tv_usec);//current time printed
//printf( "%ld %ld\n", v.it_interval.tv_sec, v.it_interval.tv_usec);//current time printed 

/*
Alarm clock printed to stdout because timer ran out before the for loop ended, program terminates 
print statement after for loop only printed if for loop ends before timer ends
*/
return 1; 
}