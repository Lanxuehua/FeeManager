# FeeManager

This is a fee manager, it record fee payment transaction and monitoring the upcoming fee payments.
As there are few people are invovled in the preparation processes, to avoid overlap and missing the record, this fee manager is introduced.

The fee manager provided following functions:
1. update the latest transaction of fee payment and record into the transaction log
2. record the system codes, settlement date, fee cycle, and processing date of the transaction
3. update the fee tracker with the latest transaction date, and estimated the next transaction date
4. set an alert for fee transacton that is expected to be processed for this month
5. monitor the number of rebates expected to be processed each month
