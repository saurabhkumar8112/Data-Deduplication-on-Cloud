# Data-Deduplication-on-Cloud
Data deduplication is an essential and critical component of backup systems. Essential, because it
reduces storage space requirements, and critical, because the performance of the entire backup
operation depends on its throughput. Traditional backup workloads consist of large data streams with
high locality, which existing deduplication techniques require to provide reasonable throughput.
Here our team did the study of methods of deduplication through which we can do deduplication.
In this project, we did 4 methods of deduplication - Fixed Length Chunking , Variable length Chunking
, Sliding gate chunking and Extreme Binning. 
# Inferences
![alt text](https://raw.githubusercontent.com/saurabhkumar8112/Data-Deduplication-on-Cloud/master/Inferences/Inference1.JPG)
![alt text](https://raw.githubusercontent.com/saurabhkumar8112/Data-Deduplication-on-Cloud/master/Inferences/Inference2JPG)
![alt text](https://raw.githubusercontent.com/saurabhkumar8112/Data-Deduplication-on-Cloud/master/Inferences/Inference3.JPG)
# Conclusion
From the results so obtained from the project, we can clearly see the trade-off between the
deduplication efficiency and the computation time. In practice as a client point of view we want that
our computation time should be small, but we also want that our storage should be used efficiently.
So we can conclude for the company point of view where the efficiency and time both matters, we
can use the extreme binning algorithm. This algorithm performs well even if we have prefixes as this
uses the variable length chunking. 
