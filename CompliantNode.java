import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {
    // array to keep track of nodes that we trust
    private boolean[] followees;
    // set that holds all transactions that the network agrees with
    private Set<Transaction> proposals; 

    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) 
    {
        // empty set for transactions
        proposals = new HashSet<Transaction>();
    }

    public void setFollowees(boolean[] followees) 
    {
        // save the variable that we follow
        this.followees = followees;
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) 
    {
        // add all transactions into prosopals
        proposals.addAll(pendingTransactions);
    }

    public Set<Transaction> getProposals() 
    {
        // return the current set
        return proposals;
    }

    public void receiveCandidates(ArrayList<Integer[]> candidates) 
    {
        // for loop that gives list of transactions that other nodes are proposing
        for (Integer[] candidate : candidates)
        {
            int txId = candidate[0];
            int senderId = candidate[1];
            // if sender is one that we follow then accept the transaction
            if (followees[senderId])
            {
                // if its known, we add it to the current set
                proposals.add(new Transaction(txId));
            }
        }
    }
}
