
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

#include <pthread.h>


char *Usage = "usage: avg-1-thread count";

#define RAND() (drand48()) /* basic Linux random number generator */

struct arg_struct     /* data type for arguments passed to a thread: 2 args */
{
    int size;           //size of array
    double *data;       // pointer to the array
};

struct result_struct /* data type for results returned by a thread */
{
    double sum;
};

/*
 Each thread begins with a function call that defines the 'body' of the thread.
 The function: void *SumThread(void *arg) is the 'entry point' for our thread.
 Linux specifies that these entry point functions should have the format:
 - take one argument of type void *
 - return a single argument of type void *
 
 (void *) is a legal pointer to any data type (char, int, double etc). 
 This tells the compiler that our program will determine the data type 
 at run time under its own control.
 
 */
void *SumThread(void *arg)
{
    int i;
    double my_sum;
    struct arg_struct *my_args;
    int my_size;
    double *my_data;
    struct result_struct *result;
    
    printf("sum thread running\n");
    fflush(stdout);
    
    /*Unmarshaling: the thread translates the generic input argument void*
      into the structure that it understands: arg_struct. This is done
     by casting the arg pointer to type struct and assigning it to my_args
     */
    my_args = (struct arg_struct *)arg;
    
    /* Allocate memory to transmit results when the thread has completed.
     */
    result = (struct result_struct *)malloc(sizeof(struct result_struct));
    
    my_size = my_args->size;
    my_data = my_args->data;  // assign pointer to array of numbers - thread's local copy
    
    free(my_args); //release the memory for the arguments structure as it is no longer needed
    
    my_sum = 0.0;
    for(i=0; i < my_size; i++) {
        my_sum += my_data[i];
    }
    
    result->sum = my_sum;  // load the sum in the results structure
    printf("sum thread done, returning\n");
    fflush(stdout);
    
    return((void *)result);   // marshaling: the result
}

int main(int argc, char **argv)
{
    int i;
    int n;
    double *data;
    int count;
    struct arg_struct *args;
    pthread_t thread_id;
    struct result_struct *result;
    int err;
    
    count = atoi(argv[1]);	/* count is first argument */
    
    
    data = (double *)malloc(count * sizeof(double));
    
    for(i=0; i < count; i++) {
        data[i] = RAND();
    }
    
    args = (struct arg_struct *)malloc(sizeof(struct arg_struct));
    
    args->size = count;
    args->data = data;
    
    printf("main thread forking sum thread\n");
    fflush(stdout);
    
    err = pthread_create(&thread_id, NULL, SumThread, (void *)args);
    
    printf("main thread running after sum thread created, about to call join\n");
    fflush(stdout);
    
    err = pthread_join(thread_id,(void **)&result);
    
    printf("main thread joined with sum thread\n");
    fflush(stdout);
    
    printf("the average over %d random numbers on (0,1) is %f\n",
           count, result->sum / (double)count);
    
    free(result);
    free(data);
    
    return(0);
}