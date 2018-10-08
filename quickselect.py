#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Mar 22 21:11:28 2018

@author: MyReservoir
"""


def randomized_select(A,p,r,k,c):

    if p==r:
        return (A[p],c)
    q,c=pivot_sel(A,p,r,c)
    i=q-p+1
    if i==k:
        return (A[q],c)
    elif k<i:
        return randomized_select(A,p,q-1,k,c)
    else:
        return randomized_select(A,q+1,r,k-i,c)


def pivot_sel(A, p, r, c):
    if (r-p+1)>=9:
        
        first=p
#        middle=int((len(A)-1)/2)
#        last=len(A)-1
        middle=int((r-p)/2)
        last=r
        print('yes')
        if A[first]<=A[middle]:
            c+=1
            if A[middle]<=A[last]:
                c+=1
                median=middle
            else:
                c+=1
                if A[first]<=A[last]:
                    c+=1
                    median=last
                else:
                    c+=1
                    median=first
        else:
            c+=1
            if A[first]<=A[last]:
                c+=1
                median=first
            else:
                c+=1
                if A[middle]<=A[last]:
                    c+=1
                    median=last
                else:
                    c+=1
                    median=middle
        A[median],A[r]=A[r],A[median]
    return partition(A,p,r,c)
   
    

def partition(A,p,r,c):
    x=A[r]
    i=p-1
    for j in range(p,r):
        if A[j]<=x:
            i+=1
            c+=1
            A[i],A[j]=A[j],A[i]
        else:
            c+=1
    A[i+1],A[r]=A[r],A[i+1]
    return (i+1,c)




sum=0
for i in range(0,10,1):
   fhand=open('10k.txt')
   A=[]
   for line in fhand:
       A.append(int(line.split('\n')[0]))
#    A=[]
#    A=[20,27,4,1,7,22]
#   A=[30,27,2,17,45,36,30,29]
#   A=[2,5,10,5,12,2,11]
   c=0
   r=len(A)-1
   k=int((len(A)+1)/2)
#    print("\n\nNew Trial")
#    print('k= ', k)
#    print('r= ', r)
#    print("Initial A= ",A)
   median,c=randomized_select(A,0,r,k,c)
   sum+=c
   print('Median= ',median)
#    print("Final A= ",A)
avg_c=int(sum/10)
print("Number of Comparisons= ", avg_c)