#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

/*
 * program to find the average value of a set of random numbers
 *
 * usage: avg-nothread count
 *
 * where count is the number of random values to generate
 */

char *Usage = "usage: avg-nothread count";

#define RAND() (drand48()) /* basic Linux random number generator */

int main(int argc, char **argv)
{
    int i;
    int n;
    double *data;
    double sum;
    int count;
    
    count = atoi(argv[1]);	/* count is first argument */
    
    /*
     * make an array large enough to hold #count# doubles
     */
    data = (double *)malloc(count * sizeof(double));
    
    /*
     * pick a bunch of random numbers
     */
    for(i=0; i < count; i++) {
        data[i] = RAND();
    }
    
    sum = 0;
    for(i=0; i < count; i++) {
        sum += data[i];
    }
    
    printf("the average over %d random numbers on (0,1) is %f\n",
           count, sum/(double)count);
    
    return(0);
}
