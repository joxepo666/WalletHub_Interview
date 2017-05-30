SET @currentRank := 0;
SELECT name, votes, @currentRank := @currentRank + 1 AS rank
FROM votes
ORDER BY votes;