package data;

/* IDataLoader (INTERFACE)
 * -----------------------------------------------------------------------------
 * Blueprint for the loaders that loads data and fills the DataContext objects.
 * -----------------------------------------------------------------------------
 * Notes:       None
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public interface IDataLoader {
    
    /* loadData
     * --------------------------------------------------
     * Loads the data from a source and creates the
     * context.
     * --------------------------------------------------
     * Input:   None
     * Output:  A data context object containing all
     *          data needed for the software to work.
     * --------------------------------------------------
     */
    public DataContext loadData();
}