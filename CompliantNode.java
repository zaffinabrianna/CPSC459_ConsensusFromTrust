import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {
    private boolean[] followees;
    private Set<Transaction> proposals; 

    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) 
    {
        proposals = new HashSet<Transaction>();
    }

    public void setFollowees(boolean[] followees) 
    {
        this.followees = followees;
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) 
    {
        proposals.addAll(pendingTransactions);
    }

    public Set<Transaction> getProposals() 
    {
        return proposals;
    }

    public void receiveCandidates(ArrayList<Integer[]> candidates) 
    {
        for (Integer[] candidate : candidates)
        {
            int txId = candidate[0];
            int senderId = candidate[1];
            if (followees[senderId])
            {
                proposals.add(new Transaction(txId));
            }
        }
    }
}
