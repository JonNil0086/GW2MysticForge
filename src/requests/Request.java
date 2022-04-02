package requests;

/* Request (INTERFACE)
 * -----------------------------------------------------------------------------
 * Blueprint for a request.
 * -----------------------------------------------------------------------------
 * Notes:       None
 * -----------------------------------------------------------------------------
 * TODO:        None
 * -----------------------------------------------------------------------------
 * Author:      Jonas Nilsson
 * Date:        22-04-01
 * Version:     1.0
 */
public interface Request {
    //Should return the end part of the URL to use for the request
    public abstract String getEndURL();
}