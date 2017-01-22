package test;

/**
 * Created by maduar on 2016/11/25.
 */
public class DynamicProgramming {
    public void AllPaths(int matrix[][]){
        int A[][]= new int[matrix.length][matrix.length];
        int n=matrix.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                A[i][j]=matrix[i][j];    //将matrix[i][j]复制到A[i][j]

        for(int k=0;k<n;k++)  //对最高下标为k的结点的路径
            for(int i=0;i<n;i++) //对于所有可能的结点对
                for(int j=0;j<n;j++)
                    //if(A[i][j]!=-1 && A[i][k]!=-1 && A[k][j]!=-1)
                    if(A[i][k]!=-1 && A[k][j]!=-1)
                    { if(A[i][j]!=-1)
                        A[i][j] = min(A[i][j],A[i][k]+A[k][j]);
                    else
                        A[i][j] = A[i][k]+A[k][j];
                    }

        //输出任意两点间的最短距离
        System.out.println("任意两点间的最短距离的矩阵表示为：");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(A[i][j]+" ");
            System.out.println();
        }
    }
    public int min(int a,int b){
        int result;
        result = a;
        if(b<a)
            result = b;
        return result;
    }
    public static void main(String[] args){
        int cost[][] ={{-1,1,2,-1,-1,-1},{-1,-1,1,3,-1,7},{-1,-1,-1,1,2,-1},   {-1,-1,-1,-1,-1,3},{-1,-1,-1,-1,-1,6},{-1,-1,-1,-1,-1,-1}}; //定义二维数组，-1表示不可到达
        DynamicProgramming instance = new DynamicProgramming();
        instance.AllPaths(cost);
    }
}
